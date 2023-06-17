import React, { useEffect, useState } from 'react';
import { View, Text, StyleSheet, TextInput, Button } from 'react-native';
import { useForm, Controller } from "react-hook-form";

const SignIn = ({ navigation }) => {

    const [registerResponse, setRegisterResponse] = useState('');
    const [errorPwConfirm, setErrorPwConfirm] = useState('');

    const { control, handleSubmit, formState: { errors } } = useForm({
        defaultValues: {
            pseudo: '',
            email: '',
            password: '',
            passwordConfirm: ''
        }
    });

    const onSubmit = async data => {
        if (data.password == data.passwordConfirm) {
            try {
                // TODO beware of URL
                const response = await fetch('http://192.168.1.19:8080/player/signin', {
                    method: 'POST',
                    headers: {
                        Accept: 'application/json',
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify({
                        email: data.email,
                        password_player: data.password,
                        pseudo_player: data.pseudo
                    }),
                });
                setRegisterResponse(await response.text())
            } catch {
                error => {
                    console.error('erreur : ' + error);
                }
            }
        } else {
            setErrorPwConfirm('Doit être identique au mot de passe.');
        }
    }
    return (
        <View style={styles.container}>
            <View>
                <Text style={styles.title}>Inscription</Text>
                {registerResponse != '' ? (
                <Text>{registerResponse}</Text>
                )
                : null}
                <View>
                    <Text style={styles.text}>Pseudonyme</Text>
                    <Controller
                        control={control}
                        rules={{
                            required: true,
                            pattern: /^[\w-\.]+$/i
                        }}
                        render={({ field: { onChange, onBlur, value } }) => (
                            <TextInput
                                onBlur={onBlur}
                                onChangeText={onChange}
                                value={value}
                            />
                        )}
                        name="pseudo"
                    />
                    {errors.pseudo && errors.pseudo.type == 'required' && <Text>Le pseudonyme est obligatoire.</Text>}
                    {errors.pseudo && errors.pseudo.type == 'pattern' && <Text>Seuls les lettres, les chiffres, les "-" et les "." sont autorisés.</Text>}
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
                    <Text style={styles.text}>Confirmation du mot de passe</Text>
                    <Controller
                        control={control}
                        rules={{
                            required: true
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
                        name="passwordConfirm"
                    />
                    {errors.passwordConfirm && errors.passwordConfirm.type == 'required' ? <Text>Le mot de passe est obligatoire.</Text> : null}
                    {errorPwConfirm != '' ? <Text>{errorPwConfirm}</Text> : null}
                    <View>
                        <Button title="Enregistrement" onPress={handleSubmit(onSubmit)} />

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

export default SignIn;