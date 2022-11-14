# Vert.x Zero Trust Demo

This is a small PoC for a vert.x Zero Trust Architecture Application.

# Development

To test on a local machine there we will need SSL (remember, don't trust, always check).

To create a self-signed key for your IP address do the following:

```sh
# replace the CN with your own IP address with suffix .nip.io
keytool \
  -genkeypair \
  -alias rsakey \
  -keyalg rsa \
  -keystore https.jks \
  -storetype JKS -dname "CN=127.0.0.1.nip.io,O=Vert.x HTTPS"

keytool \
  -genkeypair \
  -alias rsakey \
  -keyalg rsa \
  -keystore eventbus.jks \
  -storetype JKS -dname "CN=127.0.0.1.nip.io,O=Vert.x EventBus"

# convert to PKCS#12 format for compatibility reasons (you'll be prompted
# twice for the secret)
keytool \
  -importkeystore \
  -srckeystore https.jks \
  -destkeystore https.jks \
  -deststoretype pkcs12

keytool \
  -importkeystore \
  -srckeystore eventbus.jks \
  -destkeystore eventbus.jks \
  -deststoretype pkcs12

# your new ssl certificate is on the file `mytestkeys.jks`
```

Update the `MainVerticle` to use this new certificate store.

Remember this is a self-signed certificate. It will cause warnings all over, if you want to test it fully you need a
verified certificate perhaps using: https://letsencrypt.org .
