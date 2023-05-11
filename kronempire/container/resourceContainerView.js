import { Image, StyleSheet, Text, View } from "react-native";

const ResourceContainer = () => {
    const minerai = "Minerai";
    const bois = "Bois";
    const mana = "Mana";
    const kron = "Kron";
    const population = "Population";
    const moral = "Moral";
    const devotion = "Dévotion";
    
    return (
        <View style={styles.resourcesGlobal}>
        <View style={styles.resourcesLine}>
          <View style={styles.imageValue}>
            <Image
              source={require("../assets/favicon.png")}
              style={styles.images}
            />
            <Text>{minerai}</Text>
          </View>
          <View style={styles.imageValue}>
            <Image
              source={require("../assets/favicon.png")}
              style={styles.images}
            />
            <Text>{bois}</Text>
          </View>
          <View style={styles.imageValue}>
            <Image
              source={require("../assets/favicon.png")}
              style={styles.images}
            />
            <Text>{mana}</Text>
          </View>
          <View style={styles.imageValue}>
            <Image
              source={require("../assets/favicon.png")}
              style={styles.images}
            />
            <Text>{kron}</Text>
          </View>
        </View>
        <View style={styles.resourcesLine}>
          <View style={styles.imageValue}>
            <Image
              source={require("../assets/favicon.png")}
              style={styles.images}
            />
            <Text>{population}</Text>
          </View>
          <View style={styles.imageValue}>
            <Image
              source={require("../assets/favicon.png")}
              style={styles.images}
            />
            <Text>{moral}</Text>
          </View>
          <View style={styles.imageValue}>
            <Image
              source={require("../assets/favicon.png")}
              style={styles.images}
            />
            <Text>{devotion}</Text>
          </View>
        </View>
      </View>
    );
}

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

export default ResourceContainer;