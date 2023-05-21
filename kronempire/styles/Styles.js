import { StyleSheet } from "react-native";
import { Dimensions } from "react-native";

const Styles = StyleSheet.create({
    resourcesGlobal: {
      // display: 'flex',
      flex: 1,
      // backgroundColor: "gold",
      // height: 100,
      // justifyContent: "space-around",
      justifyContent: "space-evenly",
      // justifyContent: "space-between",
      // width: Dimensions.get('screen').width,
      width: 300,
      // margin: 0,
    },
    resourcesLine: {
      flexDirection: "row",
      justifyContent: "space-evenly",
      // alignItems: "center",
    },
    imageValue: {
      flexDirection: "row",
    },
    images: {
      height: 23,
      width: 23,
      marginRight: 3,
    },
    screen: {
        justifyContent: "center",
    }
  });

  export default Styles;