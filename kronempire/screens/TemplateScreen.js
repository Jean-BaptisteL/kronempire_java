import React from "react";
import { SafeAreaView } from "react-native";
import { Image, StyleSheet, Text, View } from "react-native";

const TemplateScreen = () => {
  return (
      <View>
        {/* resources container */}
        <View style={styles.resourcesGlobal}>
          <View style={styles.resourcesLine}>
            <View style={styles.imageValue}>
              <Image
                source={require("../assets/favicon.png")}
                style={styles.images}
              />
              <Text>Minerai</Text>
            </View>
            <View style={styles.imageValue}>
              <Image
                source={require("../assets/favicon.png")}
                style={styles.images}
              />
              <Text>Bois</Text>
            </View>
            <View style={styles.imageValue}>
              <Image
                source={require("../assets/favicon.png")}
                style={styles.images}
              />
              <Text>Mana</Text>
            </View>
            <View style={styles.imageValue}>
              <Image
                source={require("../assets/favicon.png")}
                style={styles.images}
              />
              <Text>Kron</Text>
            </View>
          </View>
          <View style={styles.resourcesLine}>
            <View style={styles.imageValue}>
              <Image
                source={require("../assets/favicon.png")}
                style={styles.images}
              />
              <Text>Population</Text>
            </View>
            <View style={styles.imageValue}>
              <Image
                source={require("../assets/favicon.png")}
                style={styles.images}
              />
              <Text>Moral</Text>
            </View>
            <View style={styles.imageValue}>
              <Image
                source={require("../assets/favicon.png")}
                style={styles.images}
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

export default TemplateScreen;
