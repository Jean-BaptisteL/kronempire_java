import React from "react";
import { SafeAreaView } from "react-native";
import { Image, StyleSheet, Text, View } from "react-native";

const TemplateScreen = () => {
  return (
      <View>
        {/* resources container */}
        <View style={Styles.resourcesGlobal}>
          <View style={Styles.resourcesLine}>
            <View style={Styles.imageValue}>
              <Image
                source={require("../assets/favicon.png")}
                style={Styles.images}
              />
              <Text>Minerai</Text>
            </View>
            <View style={Styles.imageValue}>
              <Image
                source={require("../assets/favicon.png")}
                style={Styles.images}
              />
              <Text>Bois</Text>
            </View>
            <View style={Styles.imageValue}>
              <Image
                source={require("../assets/favicon.png")}
                style={Styles.images}
              />
              <Text>Mana</Text>
            </View>
            <View style={Styles.imageValue}>
              <Image
                source={require("../assets/favicon.png")}
                style={Styles.images}
              />
              <Text>Kron</Text>
            </View>
          </View>
          <View style={Styles.resourcesLine}>
            <View style={Styles.imageValue}>
              <Image
                source={require("../assets/favicon.png")}
                style={Styles.images}
              />
              <Text>Population</Text>
            </View>
            <View style={Styles.imageValue}>
              <Image
                source={require("../assets/favicon.png")}
                style={Styles.images}
              />
              <Text>Moral</Text>
            </View>
            <View style={Styles.imageValue}>
              <Image
                source={require("../assets/favicon.png")}
                style={Styles.images}
              />
              <Text>Dévotion</Text>
            </View>
          </View>
        </View>

        {/* game container */}
        <Text>Template</Text>
      </View>
  );
};

const Styles = StyleSheet.create({
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

export default TemplateScreen;
