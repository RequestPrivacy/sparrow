package com.sparrowwallet.sparrow.io;

import com.sparrowwallet.drongo.crypto.ChildNumber;
import com.sparrowwallet.drongo.wallet.Bip39Calculator;
import com.sparrowwallet.drongo.wallet.Keystore;
import com.sparrowwallet.drongo.wallet.WalletModel;

import java.util.List;

public class Bip39 implements KeystoreMnemonicImport {
    @Override
    public String getName() {
        return "Mnemonic Words (BIP39)";
    }

    @Override
    public WalletModel getWalletModel() {
        return WalletModel.SPARROW;
    }

    @Override
    public String getKeystoreImportDescription() {
        return "Import your 12 to 24 word mnemonic and optional passphrase";
    }

    @Override
    public Keystore getKeystore(List<ChildNumber> derivation, List<String> mnemonicWords, String passphrase) throws ImportException {
        Bip39Calculator bip39Calculator = new Bip39Calculator();
        byte[] seed = bip39Calculator.getSeed(mnemonicWords, passphrase);
        return Keystore.fromSeed(seed, derivation);
    }
}