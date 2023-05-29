import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';
import Connection from './screens/Connection';
import SignIn from './screens/SignIn';

const Stack = createNativeStackNavigator();

export default function App() {
  return (
    // <View style={styles.container}>
    //   <Text>Ceci est un test</Text>
    //   <StatusBar style="auto" />
    // </View>
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name='Connection' component={Connection} options={
          {title: 'KronEmpire - Connexion',
          headerTitleAlign: 'center'}
          }/>
          <Stack.Screen name='SignIn' component={SignIn} options={
          {title: 'KronEmpire - Inscription',
          headerTitleAlign: 'center'}
          }/>
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
