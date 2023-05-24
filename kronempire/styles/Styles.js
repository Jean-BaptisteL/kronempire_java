import { StyleSheet } from "react-native";
import { Dimensions } from "react-native";

const Styles = StyleSheet.create({
    backgroung: {
      flex: 1,
      // justifyContent: "center",
      // justifyContent: "space-between",
      opacity: 0.5,
    },
    container: {
      flex: 1,
    },
    horizontalScrollMenu: {
      flex: 0.05,
    },
    imageValue: {
      flexDirection: "row",
    },
    images: {
      height: 23,
      width: 23,
      marginRight: 3,
    },
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
    screen: {
        justifyContent: "center",
    },
    screenText: {
      flex: 0.2,

      color: "black",
      fontSize: 25,
      fontFamily: "serif",
      fontWeight: "bold",
      textAlign: "center",
      opacity: 1,
      marginTop: 8
    },
    screenTextView: {
      marginTop: 8,
    },

    // building container
    // = screenText above
    tabName: {
      flex: 0.08,
      color: "black",
      fontSize: 25,
      fontFamily: "serif",
      fontWeight: "bold",
      textAlign: "center",
      opacity: 1,
      marginTop: 8
    },
    buildingLevel: {
      flex: 0.1,

    },
    buildingPriceGlobal: {
      flex: 0.5,
      flexDirection: 'row'

    },
    buildingImage: {
      flex: 0.5,
      resizeMode: "contain",
      // padding: 8,
      marginTop: -250,
      marginLeft: 10,
    },
    buildingPriceIn: {
      flex: 0.5,
      justifyContent: "space-evenly",
      padding: 8,
    },
    buildingPrice: {
      flex: 0.3,

    },
    buildingLocks: {
      flex: 0.3,

    },
    buildingDescription: {
      flex: 0.4,

    },
    buildingDescriptionParaph: {

    },
    // + horizontalScrollMenu see above
  });

  export default Styles;