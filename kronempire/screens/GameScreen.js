import React, {useEffect} from "react";
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

const GlobalScreen = ({ route }) => {

  const { fetchStats } = route.params;

  return (
    <NavigationContainer independent={true}>
      <Tab.Navigator
      // styling does not work on header
      // style={{flex: 1, justifyContent: "space-evenly",
      // }}
      >
        <Tab.Screen
          name="Accueil"
          component={HomeScreen}
          options={{
            headerShown: false,
            tabBarIcon: ({ size, focused, color }) => {
              return (
                <Image
                  style={{ width: 25, height: 25 }}
                  source={require("../assets/icons/home_icon.png")}
                />
              );
            },
          }}
        />
        <Tab.Screen
          name="Bâtiments"
          component={BuildingScreen}
          initialParams={{fetchStats: fetchStats}}
          options={{
            headerShown: false,
            tabBarIcon: ({ size, focused, color }) => {
              return (
                <Image
                  style={{ width: 25, height: 25 }}
                  source={require("../assets/icons/building_icon.png")}
                />
              );
            },
          }}
        />
        <Tab.Screen
          name="Technologies"
          component={TechnologyScreen}
          options={{
            headerShown: false,
            tabBarIcon: ({ size, focused, color }) => {
              return (
                <Image
                  style={{ width: 25, height: 25 }}
                  source={require("../assets/icons/technology_icon.png")}
                />
              );
            },
          }}
        />
        <Tab.Screen
          name="Recrutement"
          component={RecruitmentScreen}
          options={{
            headerShown: false,
            tabBarIcon: ({ size, focused, color }) => {
              return (
                <Image
                  style={{ width: 25, height: 25 }}
                  source={require("../assets/icons/bow_icon.png")}
                />
              );
            },
          }}
        />
        <Tab.Screen
          name="Monde"
          component={WorldScreen}
          options={{
            headerShown: false,
            tabBarIcon: ({ size, focused, color }) => {
              return (
                <Image
                  style={{ width: 25, height: 25 }}
                  source={require("../assets/icons/monde_icon.png")}
                />
              );
            },
          }}
        />
      </Tab.Navigator>
    </NavigationContainer>
  );
};

export default GlobalScreen;
