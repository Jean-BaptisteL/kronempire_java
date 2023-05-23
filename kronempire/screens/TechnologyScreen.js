import React from "react";
import { SafeAreaView } from "react-native";
import { ImageBackground, StyleSheet, Text, View } from "react-native";
import { useRoute } from "@react-navigation/native";

import ResourceContainer from "../container/resourceContainerView";
import Styles from "../styles/Styles";

const TechnologyScreen = () => {
  const router = useRoute();

  return (
    <View style={Styles.container}>
      <ImageBackground
        source={require("../assets/backgrounds/techno2_bkgd.jpg")}
        resizeMode="cover"
        style={Styles.backgroung}
      >
        {/* game container */}
        <Text style={Styles.screenText}>Technology Screen</Text>
      </ImageBackground>
    </View>
  );
};

export default TechnologyScreen;
