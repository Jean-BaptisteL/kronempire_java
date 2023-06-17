import * as React from 'react';
import { View, Text, StyleSheet, TextInput, Button } from 'react-native';
import { useForm, Controller } from "react-hook-form";
import * as SecureStore from 'expo-secure-store';

const Connection = ({ navigation }) => {

    const [connexionError, setConnexionError] = React.useState('');

    const { control, handleSubmit, formState: { errors } } = useForm({
        defaultValues: {
            email: '',
            password: ''
        }
    });

    const onSubmit = async data => {
        try {
            const response = await fetch('http://192.168.1.19:8080/player/login', {
                method: 'POST',
                headers: {
                    Accept: 'application/json',
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    email: data.email,
                    password_player: data.password
                }),
            });
            if (response.status == 200) {
                saveSecureStore('token', await response.text());
                navigation.navigate('Home');
            } else {
                setConnexionError('Email ou mot de passe incorrect');
            }
        } catch {
            error => {
                console.error('erreur : ' + error);
                setError('erreur : ' + error);
            }
        }
    }

    return (
        <View style={styles.container}>
            <View>
                <Text style={styles.title}>Connexion</Text>
                <View>
                    {connexionError == '' ? null : <Text>{connexionError}</Text>}
                    <Text style={styles.text}>Email</Text>
                    <Controller
                        control={control}
                        rules={{
                            required: true,
                            pattern: /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/i
                        }}
                        render={({ field: { onChange, onBlur, value } }) => (
                            <TextInput
                                placeholder="Adresse mail"
                                onBlur={onBlur}
                                onChangeText={onChange}
                                value={value}
                                autoCapitalize='none'
                            />
                        )}
                        name="email"
                    />
                    {errors.email && errors.email.type == 'required' && <Text>L'email est obligatoire.</Text>}
                    {errors.email && errors.email.type == 'pattern' && <Text>L'email doit être valide.</Text>}
                    <Text style={styles.text}>Mot de passe</Text>
                    <Controller
                        control={control}
                        rules={{
                            required: true,
                        }}
                        render={({ field: { onChange, onBlur, value } }) => (
                            <TextInput
                                placeholder="Mot de passe"
                                onBlur={onBlur}
                                onChangeText={onChange}
                                value={value}
                                secureTextEntry={true}
                                multiline={false}
                                autoCapitalize='none'
                            />
                        )}
                        name="password"
                    />
                    {errors.password && errors.password.type == 'required' && <Text>Le mot de passe est obligatoire.</Text>}

                    <View>
                        <Button title="Créer un compte" onPress={() => navigation.navigate('SignIn')} />
                        {/* <Button title="Se connecter" onPress={() => handleSubmit(onSubmit)} /> */}
                        <Button title="Se connecter" onPress={handleSubmit(onSubmit)} />
                    </View>
                </View>
            </View>
        </View>
    );
};

const styles = StyleSheet.create({
    container: {
        alignItems: 'center',
        justifyContent: 'center',
        flex: 1,
    },
    title: {
        textAlign: 'center',
        fontSize: 35
    },
    text: {
        fontSize: 20
    }
});

async function saveSecureStore(key, value) {
    await SecureStore.setItemAsync(key, value);
}

export default Connection;