import { useRoute } from "@react-navigation/native";
import React, { useState, useEffect } from "react";
import { ImageBackground } from "react-native";
import { Image, StyleSheet, Text, View } from "react-native";
import * as SecureStore from 'expo-secure-store';

import Styles from "../styles/Styles";

const HomeScreen = () => {

  const router = useRoute();

  return (
    <View style={Styles.container}>
      <ImageBackground source={require("../assets/backgrounds/hourglass_bkgd.jpg")}
        resizeMode="cover"
        style={Styles.backgroung}
        imageStyle={{ opacity: 0.45 }}>

        {/* game container */}
        <Text style={Styles.screenText}>Home Screen</Text>

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