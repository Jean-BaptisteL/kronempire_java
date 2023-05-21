import React from "react";
import { SafeAreaView } from "react-native";
import { Image, StyleSheet, Text, View } from "react-native";
import { useRoute } from "@react-navigation/native";

import ResourceContainer from "../container/resourceContainerView";

const TechnologyScreen = () => {

    const router = useRoute();

  return (
      <View>
        {/* resources container */}
        {/* <ResourceContainer/> */}

        {/* game container */}
        <Text>Technology Screen</Text>
      </View>
  );
};

export default TechnologyScreen;
