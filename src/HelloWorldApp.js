import React, { useState } from 'react';
import {
  StyleSheet,
  Button,
  NativeEventEmitter,
  NativeModules,
  ActivityStarterModule,
  Text,
  View,
  TextInput
} from 'react-native';

const activityStarter = NativeModules.ActivityStarter
const eventEmitter = new NativeEventEmitter(ActivityStarterModule)



class HelloWorldApp extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      data: ''
    }
  }


  componentDidMount() {
    eventEmitter.addListener(
      'DASHBOARD',
      (dataFromReact) => {
        console.log("####", dataFromReact)
        this.setState({ data: dataFromReact })
      }
    )
  }

  render() {
    let { data, inputText } = this.state;

    console.log("sdfhdkshfjkds")
    return (
      <View style={styles.container}>

        <Text>From React Button</Text>

        <TextInput
          style={styles.input}
          value={inputText}
          underlineColorAndroid="transparent"
          placeholder="Enter text to Dashboard"
          placeholderTextColor="#9a73ef"
          autoCapitalize="none"
          onChangeText={(txt) => this.setState({ inputText: txt })}
        />

        <Text></Text>
        <Button
          style={styles.submitButton}
          onPress={() => activityStarter.navigateToExample(inputText)}
          title='Start to Dashboard'
        />

        <Text></Text>
        <Text>Data From Activity</Text>
        <Text></Text>

        <Text>Data : {data}</Text>

        <Text></Text>
        <Button
          onPress={() => NativeModules.ActivityStarter.getName(
            
            (name) => { alert(name);
            
          })}

          title='Start to Post and Get Back Data'
        />

      </View>

    );

  }

}

export default HelloWorldApp;

const styles = StyleSheet.create({
  container: {
    padding: 23
  },

  input: {
    marginTop: 15,
    height: 40,
    borderColor: '#7a42f4',
    borderWidth: 1
  },

  submitButton: {
    backgroundColor: '#7a42f4',
    padding: 10,
    marginTop: 15,
    height: 40,
  },

  submitButtonText: {
    color: 'white'
  }
})