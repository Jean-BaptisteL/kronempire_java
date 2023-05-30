
import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import { StatusBar } from "expo-status-bar";
import { StyleSheet, Text, View } from "react-native";
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";

import Connection from "./screens/Connection";
import GameScreen from "./screens/GameScreen";
import TemplateScreen from "./screens/TemplateScreen";
import ResourceContainer from "./container/resourceContainerView";

const Stack = createNativeStackNavigator();

export default function App() {
  return (
    // <View style={styles.container}>
    //   <Text>Ceci est un test</Text>
    //   <StatusBar style="auto" />
    // </View>
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
        {/* TEST */}
        <Stack.Screen
          name="Home"
          component={GameScreen}
          options={{
            //   title: 'KronEmpire',
            // headerTitleAlign: 'center',
            // headerShown: false,
            headerBackVisible: false,
            headerTitle: (props) => <ResourceContainer/>,
            headerTitleAlign : 'center',
            headerStyle: {
              backgroundColor: "gold",
          },
          }}
        />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

// const styles = StyleSheet.create({
//   container: {
//     flex: 1,
//     backgroundColor: '#fff',
//     alignItems: 'center',
//     justifyContent: 'center',
//   },
// });
