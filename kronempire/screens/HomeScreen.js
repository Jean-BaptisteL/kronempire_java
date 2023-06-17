import { useRoute } from "@react-navigation/native";
import React, { useState, useEffect } from "react";
import { ImageBackground } from "react-native";
import { Image, StyleSheet, Text, View } from "react-native";
import * as SecureStore from 'expo-secure-store';
import moment from "moment";
import { CountdownCircleTimer } from 'react-native-countdown-circle-timer';
import 'moment-timezone';

import Styles from "../styles/Styles";

const HomeScreen = ({ route }) => {

  const { buildingConstruction } = route.params;
  console.log(buildingConstruction);

  const [seconds, setSeconds] = useState(0);

  const [isDisplayed, setIsDisplayed] = useState(false);


  useEffect(() => {
    if (Object.keys(buildingConstruction).length != 0) {
      const localDate = new Date();
      const endDate = new Date(buildingConstruction.date);

      console.log(localDate);
      console.log(endDate);

      const sec = (endDate.getTime() - localDate.getTime()) / 1000;
      setSeconds(sec);
      setIsDisplayed(true);
      console.log(sec);

    }
  }, []);

  const router = useRoute();

  return (
    <View style={Styles.container}>
      <ImageBackground source={require("../assets/backgrounds/hourglass_bkgd.jpg")}
        resizeMode="cover"
        style={Styles.backgroung}
        imageStyle={{ opacity: 0.45 }}>

        {/* game container */}
        <Text style={Styles.screenText}>Votre empire</Text>

        {isDisplayed ?
          <CountdownCircleTimer
            isPlaying
            duration={seconds}
            colors={['#004777', '#F7B801', '#A30000', '#A30000']}
            colorsTime={[7, 5, 2, 0]}
          />
          : null}

      </ImageBackground>
    </View>
  );
};

async function getSecureStoreValueFor(key) {
  let result = await SecureStore.getItemAsync(key);
  if (result) {
    return result;
  } else {
    return null;
  }
}

export default HomeScreen;