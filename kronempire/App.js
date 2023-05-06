import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';
import Cat from './Test';

export default function App() {
  return (
    <View style={styles.container}>
      <Text>Ceci est un test</Text>
      <StatusBar style="auto" />
      <Cat></Cat>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
