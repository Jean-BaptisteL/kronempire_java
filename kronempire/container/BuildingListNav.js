import React from "react";
import { View, Text, TouchableOpacity } from "react-native";

import Styles from "../styles/Styles";

const BuildingListNav = ({building}) => {

    return (
        <TouchableOpacity onPress={test(building)}>
            <View>
                <Text style={Styles.horizontalMenuItem}>{building.name_building}</Text>
            </View>
        </TouchableOpacity>

    );
};

BuildingListNav.defaultProps = {
    name: 'unknown'
};

export default BuildingListNav