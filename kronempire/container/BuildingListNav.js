import React from "react";
import { View, Text, TouchableOpacity } from "react-native";

import Styles from "../styles/Styles";

const BuildingListNav = ({buildingName}) => {

    return (
        <TouchableOpacity>
            <View>
                <Text style={Styles.horizontalMenuItem}>{buildingName.name}</Text>

            </View>
            
        </TouchableOpacity>

    );
};

BuildingListNav.defaultProps = {
    name: 'unknown'
};

export default BuildingListNav