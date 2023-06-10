import { useRoute } from "@react-navigation/native";
import { React, useEffect, useState } from "react";
import { ImageBackground, SafeAreaView } from "react-native";
import { FlatList, Image, StyleSheet, Text, View } from "react-native";
import * as SecureStore from "expo-secure-store";

import Styles from "../styles/Styles";

const HomeScreen = () => {
  const [registerResponse, setRegisterResponse] = useState("");
  const [playerStat, setPlayerStat] = useState([]);

  const router = useRoute();

  const token = async () => await SecureStore.getItemAsync("token");

  // useEffect avec en second param la liste des éléments qui changent pour refaire
  // [] liste vide => ComponentDidMount, ici quand la vue est chargée
  useEffect(() => {
    getStat();
    console.log("playerStat ::" + playerStat);
  }, []);

  const getStat = async () => {
    try {
      const response = await fetch("http://192.168.1.7:8080/playerStat/get", {
        method: "GET",
        headears: {
          Accept: "application/json",
          "Content-Type": "application/json",
          Authorization: "Bearer " + token,
        },
      });
      const jsonResp = await response.json();
      setPlayerStat(jsonResp);
      console.log("lalalala" + jsonResp)
    } catch {
      (error) => {
        console.error("error" + error);
      };
    }
  };

  return (
    <View style={Styles.container}>
      <ImageBackground
        source={require("../assets/backgrounds/hourglass_bkgd.jpg")}
        resizeMode="cover"
        style={Styles.backgroung}
        imageStyle={{ opacity: 0.45 }}
      >
        {/* game container */}
        <Text style={Styles.screenText}>Home Screen</Text>
        <View style={{ flex: 1, padding: 24 }}>
            <FlatList
              data={playerStat}
              keyExtractor={({ id }) => id}
              renderItem={({ item }) => (
                <Text>
                  {item.wood}, {item}
                </Text>
              )}
            />
        </View>
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
