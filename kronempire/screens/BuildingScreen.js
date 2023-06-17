import React, { useState, useEffect } from "react";
import { ActivityIndicator, FlatList } from "react-native";
import { Button, Image, ImageBackground, TouchableOpacity, Text, View, } from "react-native";
import Styles from "../styles/Styles";
import * as SecureStore from 'expo-secure-store';

const BuildingScreen = ({ route }) => {

  const { fetchStats } = route.params;

  const [loading, setLoading] = useState(true);

  const [buildings, setBuildings] = useState([]);

  const [shownBuilding, setShownBuilding] = useState({});

  const [buildingsNeedsTech, setBuildingsNeedsTech] = useState({});

  const [shownBuildingNeedsTech, setShownBuildingNeedsTech] = useState([]);

  const [buttonLabel, setButtonLabel] = useState("Construire");

  const showBuilding = (building) => {
    setShownBuilding(building);
    setShownBuildingNeedsTech(buildingsNeedsTech.filter(bNT => {
      return bNT.building.id_building === building.id_building
    }));
  }

  async function buildingContruction(data) {
  // const buildingContruction = async data => {
    token = await getSecureStoreValueFor('token');
    try {
      const response = await fetch('http://192.168.1.19:8080/stats/construct', {
        method: 'PUT',
        headers: {
          Accept: 'application/json',
          'Content-Type': 'application/json',
          Authorization: "Bearer " + token
        },
        body: JSON.stringify({
          buildingId: data,
        }),
      });
      if (response.status == 200) {
        setButtonLabel("Abandonner");
        fetchStats();
      } else {
        // pop up message ; construction non lancée parce que
      }
    } catch {
      error => {
        console.error('erreur : ' + error);
        setError('erreur : ' + error);
      }
    }
  };

  useEffect(() => {
    async function fetchBuildings() {
      token = await getSecureStoreValueFor('token');
      try {
        const response = await fetch('http://192.168.1.19:8080/buildings/all', {
          method: 'GET',
          headers: {
            Accept: 'application/json',
            'Content-Type': 'application/json',
            Authorization: "Bearer " + token
          },
        });
        var data = JSON.parse(await response.text());
        setBuildings(data.buildings);
        setBuildingsNeedsTech(data.buildingNeedsTechnologies);
      } catch (error) {
        console.error(error);
      }
    }
    fetchBuildings();
  }, []);

  useEffect(() => {
    if (buildings.length != 0) {
      setShownBuilding(buildings[0]);
    }
  }, [buildings]);

  useEffect(() => {
    if (Object.keys(shownBuilding).length != 0) {
      setLoading(false);
    }
  }, [shownBuilding]);

  var technologiesNeeded = [];
  for (let i = 0; i < shownBuildingNeedsTech.length; i++) {
    technologiesNeeded.push(
      <Text key={i}>Technologie {shownBuildingNeedsTech[i].technology.name_tech} niv. {shownBuildingNeedsTech[i].level} </Text>
    );
  }

  if (loading) {
    return (
      <View style={Styles.container}>
        <ActivityIndicator />
      </View>
    );
  } else {
    return (
      <View style={Styles.container}>
        <ImageBackground
          source={require("../assets/backgrounds/building_bkgd.jpg")}
          resizeMode="cover"
          style={Styles.backgroung}
          imageStyle={{ opacity: 0.45 }}
        >
          {/* game container */}
          {/* 1 */}
          <Text style={Styles.tabName}>{shownBuilding.name_building}</Text>
          {/* 2 */}
          <View style={Styles.buildingLevel}>
            <Text>Niveau actuel du bati : +ressouces/sec</Text>
            <Text>Niveau prochain du bati : +ressouces/sec</Text>
          </View>
          {/* 3 */}

          <View style={Styles.buildingPriceGlobal}>
            <Image style={Styles.buildingImage}
              source={require("../assets/backgrounds/building_bkgd.jpg")}>
            </Image>
            {/* Carracteristiques pour le niveau suivant (sur la droite) */}
            <View style={Styles.buildingPriceIn}>
              <View style={Styles.buildingPrice}>
                <Text>Cout en Minerai : {shownBuilding.metalPrice_building}</Text>
                <Text>Cout en Bois: {shownBuilding.woodPrice_building}</Text>
                <Text>Cout en Mana: {shownBuilding.manaPrice_building}</Text>
                <Text>Cout en Kron: {shownBuilding.kronPrice_building}</Text>

                <Text>Temps de construction : {shownBuilding.buildTime_building} sec.</Text>
              </View>
              {shownBuildingNeedsTech.length != 0 ?
                <View style={Styles.buildingLocks}>
                  <Text>Nécessite:</Text>
                  {technologiesNeeded}
                </View>
                : null}
            </View>
          </View >
          <View style={Styles.buildinConstructionButton}>
            <Button
              styleDisabled={{ color: "grey" }}
              onPress={() => buildingContruction(shownBuilding.id_building)}
              title={buttonLabel}
              style={Styles.buildinConstructionButton}
            >
              Construire
            </Button>
          </View>
          {/* 4 */}

          <View style={Styles.buildingDescription}>
            <Text>Description:</Text>
            <Text style={Styles.buildingDescriptionParaph}>
              {shownBuilding.description_building}
            </Text>
          </View>

          {/* 5 */}
          <View style={Styles.horizontalScrollMenu}>
            <FlatList
              horizontal={true}
              data={buildings}
              // renderItem={({ item }) => (<BuildingListNav buildingName={item} />)}
              renderItem={({ item }) => (
                <TouchableOpacity onPress={() => { showBuilding(item) }}>
                  <View>
                    <Text style={Styles.horizontalMenuItem}>{item.name_building}</Text>
                  </View>
                </TouchableOpacity>
              )}
            />
          </View>



        </ImageBackground>
      </View>
    );
  }
};

async function getSecureStoreValueFor(key) {
  let result = await SecureStore.getItemAsync(key);
  if (result) {
    return result;
  } else {
    return null;
  }
}

export default BuildingScreen;
