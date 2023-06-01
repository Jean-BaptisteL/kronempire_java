import React, { useState } from "react";
import { FlatList, SafeAreaView, ScrollView } from "react-native";
import {
  Button,
  Image,
  ImageBackground,
  StyleSheet,
  Text,
  View,
} from "react-native";

import { useRoute } from "@react-navigation/native";

import ResourceContainer from "../container/resourceContainerView";
import BuildingListNav from "../container/BuildingListNav";
import Styles from "../styles/Styles";

const BuildingScreen = () => {
  const router = useRoute();

  const [buildingNames, setBuildingNames] = useState([
    // Bâtiments ressources
    {building: 1, name: 'Mine'},
    {building: 2, name: 'Scierie'},
    {building: 3, name: 'Distillerie de mana'},
    {building: 4, name: 'Planque'},
    // Bâtiments pour la population
    {building: 5, name: 'Taverne'},
    {building: 6, name: 'Autel'},
    {building: 7, name: 'Habitation'},
    {building: 8, name: 'Stadium'},
    {building: 9, name: 'Temple'},
    // Bâtiments avancés
    {building: 10, name: 'Caserne'},
    {building: 11, name: 'Observatoire arcanique'},
    {building: 12, name: 'Portail de téléportation'},
    {building: 13, name: 'Kronlard'},
    {building: 14, name: 'Atelier de siège'},
    {building: 15, name: 'Volière'},
    // Bâtiments de défense
    {building: 16, name: 'Barrière en bois'},
    {building: 17, name: 'Rempart'},
    {building: 18, name: 'Tourelle'},
    {building: 19, name: 'Tourelle arcanique'},
    {building: 20, name: 'Bouclier magique'},
  ]);

  return (
    <View style={Styles.container}>
      <ImageBackground
        source={require("../assets/backgrounds/building_bkgd.jpg")}
        resizeMode="cover"
        style={Styles.backgroung}
        imageStyle={{opacity:0.45}}
      >
        {/* game container */}
        {/* 1 */}
        <Text style={Styles.tabName}>Nom du batiment (variable)</Text>
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
              <Text>Cout en minerai</Text>
              <Text>Cout en bois</Text>
              <Text>Cout en Mana</Text>

              <Text>Temps de construction</Text>
            </View>
            <View style={Styles.buildingLocks}>
              <Text>Nécessite:</Text>
              <Text>Bâtiment X niv Y </Text>
              <Text>Technologie X niv Y </Text>
            </View>
          </View>
        </View >
        <View style={Styles.buildinConstructionButton}>
            <Button
              styleDisabled={{ color: "grey" }}
              onPress={() => console.log("Button pressed")}
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
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Beatae, blanditiis. Exercitationem, quae eveniet sit sequi perspiciatis a recusandae porro accusantium atque ab pariatur corporis officia vitae ut. Recusandae iure fugit modi obcaecati eligendi est inventore consequatur quae doloribus? Perferendis doloremque soluta iure at dicta omnis! Expedita, quos error deserunt, ipsum quaerat similique quas quisquam deleniti eum culpa nemo atque incidunt.
          </Text>
        </View>
        
        {/* 5 */}
        <View style={Styles.horizontalScrollMenu}>
          <FlatList
            horizontal = {true} 
            data = {buildingNames}
            renderItem = { ({item}) => (<BuildingListNav buildingName={item}/>)}
          />
        </View>



      </ImageBackground>
    </View>
  );
};

export default BuildingScreen;
