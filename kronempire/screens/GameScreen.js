import React from "react";
import { SafeAreaView } from "react-native";
import { Image, StyleSheet, Text, View } from "react-native";
import { NavigationContainer, Router } from "@react-navigation/native";
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";

import HomeScreen from "./HomeScreen";
import BuildingScreen from "./BuildingScreen";
import TechnologyScreen from "./TechnologyScreen";
import RecruitmentScreen from "./RecruitmentScreen";
import WorldScreen from "./WorldScreen";

const Tab = createBottomTabNavigator();

const GlobalScreen = () => {
  return (
    <NavigationContainer independent={true}>
        <Tab.Navigator>
            <Tab.Screen name="Accueil" component={HomeScreen}/>
            <Tab.Screen name="Bâtiments" component={BuildingScreen}/>
            <Tab.Screen name="Technologies" component={TechnologyScreen}/>
            <Tab.Screen name="Recrutement" component={RecruitmentScreen}/>
            <Tab.Screen name="Monde" component={WorldScreen}/>
        </Tab.Navigator>
    </NavigationContainer>
  );
};

export default GlobalScreen;
