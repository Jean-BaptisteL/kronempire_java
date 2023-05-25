import React from "react";
import { SafeAreaView, ScrollView } from "react-native";
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
import Styles from "../styles/Styles";

const BuildingScreen = () => {
  const router = useRoute();

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
          <ScrollView horizontal={true}>
            {/* Bâtiments ressources */}
            <Text>Mine-</Text>
            <Text>SCierie-</Text>
            <Text>Distillerie de mana-</Text>
            <Text>Planque-</Text>
            {/* Bâtiments pour la population */}
            <Text>Taverne-</Text>
            <Text>Autel-</Text>
            <Text>Habitation-</Text>
            <Text>Stadium-</Text>
            <Text>Temple-</Text>
            {/* Bâtiments avancés */}
            <Text>Caserne</Text>
            <Text>Observatoire arcanique-</Text>
            <Text>Portail de téléportation-</Text>
            <Text>Kronlard-</Text>
            <Text>Atelier de siège-</Text>
            <Text>Volière</Text>
            {/* Bâtiments de défense */}
            <Text>Barrière en bois-</Text>
            <Text>Rempart-</Text>
            <Text>Tourell-e</Text>
            <Text>Tourelle arcanique-</Text>
            <Text>Bouclier magique</Text>
          </ScrollView>
        </View>

      </ImageBackground>
    </View>
  );
};

export default BuildingScreen;
