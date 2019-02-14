function mainEncode(encoder, password) {
    return encoder(password);
}

function plainEncoder(password) {
    return password;
}

function sha1Encoder(password) {
    // ....
}

mainEncode(plainEncoder, "123");
