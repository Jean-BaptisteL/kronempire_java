import React, { useState, useEffect } from "react";
import { ActivityIndicator, FlatList } from "react-native";
import { Button, Image, ImageBackground, TouchableOpacity, Text, View, } from "react-native";
import Styles from "../styles/Styles";
import * as SecureStore from 'expo-secure-store';

const BuildingScreen = ({ route }) => {

  const { fetchStats } = route.params;

  const [loading, setLoading] = useState(true);

  const [buildings, setBuildings] = useState([]);

  const [showedBuilding, setShowedBuilding] = useState({});

  const [buildingsNeedsTech, setBuildingsNeedsTech] = useState({});

  const [showedBuildingNeedsTech, setShowedBuildingNeedsTech] = useState([]);

  const showBuilding = (building) => {
    setShowedBuilding(building);
    setShowedBuildingNeedsTech(buildingsNeedsTech.filter(bNT => {
      return bNT.building.id_building === building.id_building
    }));
  }

  const buildingContruction = async data => {
    try {
      const response = await fetch('http://192.168.1.19:8080/player/login', {
        method: 'POST',
        headers: {
          Accept: 'application/json',
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          email: data.email,
          password_player: data.password
        }),
      });
      if (response.status == 200) {
        saveSecureStore('token', await response.text());
        navigation.navigate('Home');
      } else {
        setConnexionError('Email ou mot de passe incorrect');
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
      setShowedBuilding(buildings[0]);
    }
  }, [buildings]);

  useEffect(() => {
    if (Object.keys(showedBuilding).length != 0) {
      setLoading(false);
    }
  }, [showedBuilding]);

  var technologiesNeeded = [];
  for (let i = 0; i < showedBuildingNeedsTech.length; i++) {
    technologiesNeeded.push(
      <Text key={i}>Technologie {showedBuildingNeedsTech[i].technology.name_tech} niv. {showedBuildingNeedsTech[i].level} </Text>
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
          <Text style={Styles.tabName}>{showedBuilding.name_building}</Text>
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
                <Text>Cout en Minerai : {showedBuilding.metalPrice_building}</Text>
                <Text>Cout en Bois: {showedBuilding.woodPrice_building}</Text>
                <Text>Cout en Mana: {showedBuilding.manaPrice_building}</Text>
                <Text>Cout en Kron: {showedBuilding.kronPrice_building}</Text>

                <Text>Temps de construction : {showedBuilding.buildTime_building} sec.</Text>
              </View>
              {showedBuildingNeedsTech.length != 0 ?
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
              onPress={() => buildingContruction()}
              title="Construire"
              style={Styles.buildinConstructionButton}
            >
              Construire
            </Button>
          </View>
          {/* 4 */}

          <View style={Styles.buildingDescription}>
            <Text>Description:</Text>
            <Text style={Styles.buildingDescriptionParaph}>
              {showedBuilding.description_building}
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
