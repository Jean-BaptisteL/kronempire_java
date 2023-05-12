import { Image, StyleSheet, Text, View } from "react-native";

import Styles from "../styles/Styles";

const ResourceContainer = () => {
    const minerai = "Minerai";
    const bois = "Bois";
    const mana = "Mana";
    const kron = "Kron";
    const population = "Population";
    const moral = "Moral";
    const devotion = "Dévotion";
    
    return (
        <View style={Styles.resourcesGlobal}>
        <View style={Styles.resourcesLine}>
          <View style={Styles.imageValue}>
            <Image
              source={require("../assets/icons/gold-lingots_icon.png")}
              style={Styles.images}
            />
            <Text>{minerai}</Text>
          </View>
          <View style={Styles.imageValue}>
            <Image
              source={require("../assets/icons/tree_icon.png")}
              style={Styles.images}
            />
            <Text>{bois}</Text>
          </View>
          <View style={Styles.imageValue}>
            <Image
              source={require("../assets/icons/mana_icon.png")}
              style={Styles.images}
            />
            <Text>{mana}</Text>
          </View>
          <View style={Styles.imageValue}>
            <Image
              source={require("../assets/icons/kron-light.png")}
              style={Styles.images}
            />
            <Text>{kron}</Text>
          </View>
        </View>
        <View style={Styles.resourcesLine}>
          <View style={Styles.imageValue}>
            <Image
              source={require("../assets/icons/population_icon.png")}
              style={Styles.images}
            />
            <Text>{population}</Text>
          </View>
          <View style={Styles.imageValue}>
            <Image
              source={require("../assets/icons/happy-smiley.png")}
              style={Styles.images}
            />
            <Text>{moral}</Text>
          </View>
          <View style={Styles.imageValue}>
            <Image
              source={require("../assets/icons/devotion_icon.png")}
              style={Styles.images}
            />
            <Text>{devotion}</Text>
          </View>
        </View>
      </View>
    );
}

export default ResourceContainer;