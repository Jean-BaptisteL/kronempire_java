import React from "react";
import { SafeAreaView } from "react-native";
import { ImageBackground, StyleSheet, Text, View } from "react-native";
import { useRoute } from "@react-navigation/native";

import ResourceContainer from "../container/resourceContainerView";
import Styles from "../styles/Styles";

const RecruitmentScreen = () => {
  const router = useRoute();

  return (
    <View style={Styles.container}>
      <ImageBackground
        source={require("../assets/backgrounds/recruitment_bkgd.jpg")}
        resizeMode="cover"
        style={Styles.backgroung}
      >
        {/* game container */}
        <Text style={Styles.screenText}>Recruitment Screen</Text>
      </ImageBackground>
    </View>
  );
};

const styles = StyleSheet.create({
  resourcesGlobal: {
    // alignItems: 'center',
    backgroundColor: "gold",
    height: 100,
    justifyContent: "space-evenly",
  },
  resourcesLine: {
    flexDirection: "row",
    justifyContent: "space-evenly",
    // alignItems: "center",
  },
  imageValue: {
    flexDirection: "row",
  },
  images: {
    height: 23,
    width: 23,
  },
});

export default RecruitmentScreen;
