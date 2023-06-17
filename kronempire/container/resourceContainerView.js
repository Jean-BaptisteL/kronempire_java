import { Image, StyleSheet, Text, View } from "react-native";

import Styles from "../styles/Styles";
import { useEffect, useState } from "react";

const ResourceContainer = ({playerStats, playerHasBuildings}) => {

  console.log(playerHasBuildings);

  function calculateResources(retrievedValue, xFactor) {
    const [newValue, setResourceValue] = useState(retrievedValue);
    useEffect( () => {
      const timer = setInterval( () => {
        setResourceValue(newValue + xFactor);
      }, 1000);
  
      return () => clearInterval(timer);
    });

    return Math.trunc(newValue);
  };

  const renderOre = () => {return parseInt(calculateResources(playerStats.metalQuantity_player_stat, playerHasBuildings[0].building.levelFactor_building * (1 + playerHasBuildings[0].level)))};
  const renderWood = () => {return parseInt(calculateResources(playerStats.woodQuantity_player_stat, playerHasBuildings[1].building.levelFactor_building * (1 + playerHasBuildings[1].level)))};
  const renderMana = () => {return parseInt(calculateResources(playerStats.manaQuantity_player_stat, playerHasBuildings[2].building.levelFactor_building * (1 + playerHasBuildings[2].level)))};
  const renderKron = () => {return parseInt(calculateResources(playerStats.kronQuantity_player_stat, 0.1 * playerStats.popQuantity_player_stat))};
  const renderPopulation = () => {return parseInt(calculateResources(playerStats.popQuantity_player_stat, 2.2))};
  const renderMood = () => {return 50};
  const renderDevotion = () => {return 50};

  return (
    <View style={Styles.resourcesGlobal}>
      <View style={Styles.resourcesLine}>
        <View style={Styles.imageValue}>
          <Image
            source={require("../assets/icons/gold-lingots_icon.png")}
            style={Styles.images}
          />
          <Text>{renderOre()}</Text>
        </View>
        <View style={Styles.imageValue}>
          <Image
            source={require("../assets/icons/tree_icon.png")}
            style={Styles.images}
          />
          <Text>{renderWood()}</Text>
        </View>
        <View style={Styles.imageValue}>
          <Image
            source={require("../assets/icons/mana_icon.png")}
            style={Styles.images}
          />
          <Text>{renderMana()}</Text>
        </View>
        <View style={Styles.imageValue}>
          <Image
            source={require("../assets/icons/kron-light.png")}
            style={Styles.images}
          />
          <Text>{renderKron()}</Text>
        </View>
      </View>
      <View style={Styles.resourcesLine}>
        <View style={Styles.imageValue}>
          <Image
            source={require("../assets/icons/population_icon.png")}
            style={Styles.images}
          />
          <Text>{renderPopulation()}</Text>
        </View>
        <View style={Styles.imageValue}>
          <Image
            source={require("../assets/icons/happy-smiley.png")}
            style={Styles.images}
          />
          <Text>{renderMood()}</Text>
        </View>
        <View style={Styles.imageValue}>
          <Image
            source={require("../assets/icons/devotion_icon.png")}
            style={Styles.images}
          />
          <Text>{renderDevotion()}</Text>
        </View>
      </View>
    </View>
  );
};

export default ResourceContainer;
