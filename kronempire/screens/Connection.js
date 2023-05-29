import * as React from 'react';
import { View, Text, StyleSheet, TextInput, Button } from 'react-native';
import { useForm, Controller } from "react-hook-form";

const Connection = ({navigation}) => {
    const { control, handleSubmit, formState: { errors } } = useForm({
        defaultValues: {
            email: '',
            password: ''
        }
    });
    const onSubmit = data => console.log(data);
    // redirection to Home page after connection
    // const onSubmit = navigation.navigate('Home');
    const enterGame = navigation.navigate('Home');
    
    return (
        <View style={styles.container}>
            <View>
                <Text>Connexion</Text>
                <View>
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
                    <Button title="Se connecter" onPress={handleSubmit(onSubmit, enterGame)} />
                </View>
            </View>
        </View>
    );
};

const styles = StyleSheet.create({
    container: {
        alignItems: 'center',
        justifyContent: 'center',
        // verticalAlign: 'middle'
    }
});

export default Connection;