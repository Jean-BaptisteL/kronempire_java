import React from "react";
import { SafeAreaView } from "react-native";
import { Image, StyleSheet, Text, View } from "react-native";
import { useRoute } from "@react-navigation/native";

import ResourceContainer from "../container/resourceContainerView";

const RecruitmentScreen = () => {
    
    const router = useRoute();
    
  return (
      <View>
        {/* resources container */}
       <ResourceContainer/>

        {/* game container */}
        <Text>Recruitment Screen</Text>
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
