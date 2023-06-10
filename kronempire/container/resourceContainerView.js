import { Image, StyleSheet, Text, View } from "react-native";

import Styles from "../styles/Styles";
import { useEffect, useState } from "react";

const ResourceContainer = () => {
  // console.log('ENTRE DANS RESOURCE CONTAINER');

  const onLoading = async data => {
    // const response = await fetch('http://192.168.1.7:8080/playerStat/get', {
    //       method: 'GET',
    //       headers: {
    //         Accept: 'application/json',
    //         'Content-Type': 'application/json',
    //         Authorization: "Bearer " + token
    //       },
    //     });

    try {
      console.log('preeeeeeeseeeeeeent');
      const response = await fetch('http://192.168.1.7:8080/playerStat/get', {
        method: 'GET',
        headears: {
          Accept: 'application/json',
          'Content-Type': 'application/json',
          Authorization: "Bearer " + token,
        },
        body: JSON.stringify({
          wood: data.wood,
        })
    });
    console.log('preeeeeeeseeeeeeent');
    setRegisterResponse(await response.text());
    } catch {
      error => {
        console.error('error' + error);
      }
    }
  }

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

  const renderOre = () => {return parseInt(calculateResources(1, 6.2))};
  const renderWood = () => {return parseInt(calculateResources(1, 5.2))};
  const renderMana = () => {return parseInt(calculateResources(1, 4.2))};
  const renderKron = () => {return parseInt(calculateResources(1, 3.2))};
  const renderPopulation = () => {return parseInt(calculateResources(1, 2.2))};
  const renderMood = () => {return parseInt(calculateResources(1, 1.2))};
  const renderDevotion = () => {return parseInt(calculateResources(1, 1.2))};

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
