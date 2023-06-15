import { StyleSheet } from "react-native";
import { Dimensions } from "react-native";

const Styles = StyleSheet.create({
    backgroung: {
      flex: 1,
      // justifyContent: "center",
      // justifyContent: "space-between",
      // opacity: 0.5,
    },
    container: {
      flex: 1,
    },
    horizontalScrollMenu: {
      flex: 1,
      margin: 8,
      alignItems: "center",

    },
    horizontalMenuItem: {
      // fontSize:100,
      color:'#FFFFFF',
      borderWidth: 2,
      borderColor: 'gold',
      // backgroundColor: '#000000',
      paddingLeft:8,
      paddingRight:8,
      // textShadowColor:'#000000',
      // textShadowOffset:{width: 8, height: 8},
      // textShadowRadius:33,  
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
      flex: 1,
      color: "black",
      fontSize: 25,
      fontFamily: "serif",
      fontWeight: "bold",
      textAlign: "center",
      opacity: 1,
      paddingTop: 50,
    },
    buildingLevel: {
      flex: 1,
      margin: 20,

    },
    buildingPriceGlobal: {
      flex: 3,
      flexDirection: 'row',
      margin: 8,

    },
    buildingImage: {
      flex: 1,
      resizeMode: "contain",
      // padding: 8,
      // marginTop: -300,
      marginLeft: 10,
      alignSelf: 'center',
      // borderRadius: 5,
    },
    buildingPriceIn: {
      flex: 1,
      justifyContent: "space-evenly",
      // padding: 8,
      margin: 8,

    },
    buildingPrice: {
      // flex: 1,
      // paddingBottom: 30,

    },
    buildingLocks: {
      // flex: 1,

    },
    buildinConstructionButton: {
      flex: 1,
      margin: 18,
      borderRadius: 50,
    },
    buildingDescription: {
      flex: 3,
      margin: 8,
      
    },
    buildingDescriptionParaph: {
      textAlign: 'justify',

    },
    // + horizontalScrollMenu see above
  });

  export default Styles;