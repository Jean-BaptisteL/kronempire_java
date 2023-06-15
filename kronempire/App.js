
import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";

import Connection from "./screens/Connection";
import GameScreen from "./screens/GameScreen";
import ResourceContainer from "./container/resourceContainerView";
import SignIn from "./screens/SignIn";

const Stack = createNativeStackNavigator();

export default function App() {
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
