/**
 * @format
 */

import {AppRegistry} from 'react-native';
import {name as appName} from './app.json';
import HelloWorldApp from './src/HelloWorldApp';

AppRegistry.registerComponent(appName, () => HelloWorldApp);
