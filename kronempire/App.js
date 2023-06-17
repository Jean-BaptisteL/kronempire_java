
import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";

import Connection from "./screens/Connection";
import GameScreen from "./screens/GameScreen";
import ResourceContainer from "./container/resourceContainerView";
import SignIn from "./screens/SignIn";
import { useState, useEffect } from "react";
import * as SecureStore from 'expo-secure-store';

const Stack = createNativeStackNavigator();


export default function App() {

  const [playerStats, setPlayerStats] = useState({});
  const [playerHasBuildings, setPlayerHasBuildings] = useState({});
  const [buildingConstruction, setBuildingConstruction] = useState({});

  async function getSecureStoreValueFor(key) {
    let result = await SecureStore.getItemAsync(key);
    if (result) {
      return result;
    } else {
      return null;
    }
  }

  useEffect(() => {
    fetchStats();
  }, []);

  // Récupération des statistique du joueur
  async function fetchStats() {
    token = await getSecureStoreValueFor('token');
    try {
      const response = await fetch('http://192.168.1.19:8080/stats/get', {
        method: 'GET',
        headers: {
          Accept: 'application/json',
          'Content-Type': 'application/json',
          Authorization: "Bearer " + token
        },
      });
      if (response.status === 200) {
        var data = JSON.parse(await response.text());
        setPlayerStats(data.stat);
        setPlayerHasBuildings(data.playerHasBuildings);
        setBuildingConstruction(data.buildingConstruction == null ? {} : data.buildingConstruction);
      } else {
        alert('Une erreur s\'est produite');
      }

    } catch (error) {
      console.error(error);
    }
  }

  return (
    <NavigationContainer independent={true}>
      <Stack.Navigator>

        <Stack.Screen
          name="Connection"
          component={Connection}
          options={{
            title: "KronEmpire - Connexion",
            headerTitleAlign: "center",
          }}
        />
        <Stack.Screen
          name="SignIn"
          component={SignIn}
          options={{
            title: "KronEmpire - Inscription",
            headerTitleAlign: "center",
          }}
        />
        {/* TEST */}
        <Stack.Screen
          name="Home"
          component={GameScreen}
          initialParams={{ fetchStats: fetchStats, buildingConstruction: buildingConstruction }}
          options={{
            //   title: 'KronEmpire',
            // headerTitleAlign: 'center',
            // headerShown: false,
            headerBackVisible: false,
            headerTitle: (props) => <ResourceContainer playerStats={playerStats} playerHasBuildings={playerHasBuildings} />,
            headerTitleAlign: 'center',
            headerStyle: {
              backgroundColor: "gold",
            },
          }}
        />
      </Stack.Navigator>
    </NavigationContainer>
  );
}
