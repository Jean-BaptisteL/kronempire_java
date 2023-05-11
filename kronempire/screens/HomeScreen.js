import { useRoute } from "@react-navigation/native";
import React from "react";
import { SafeAreaView } from "react-native";
import { Image, StyleSheet, Text, View } from "react-native";

import ResourceContainer from "../container/resourceContainerView";

const HomeScreen = () => {

    const router = useRoute();

  return (
      <View>
        {/* resources container */}
        <ResourceContainer/>

        {/* game container */}
        <Text>Home Screen</Text>
      </View>
  );
};

export default HomeScreen;