import { StyleSheet, View, Text } from 'react-native';

const PlaceholderImage = require('@/assets/images/icon.png');

export default function Index() {
  return (
    <View style={styles.container}>
      <Text>Test</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
    backgroundColor: 'rgba(211, 211, 211, 1)',
  },
  text: {
    color: '#000',
  },
});
