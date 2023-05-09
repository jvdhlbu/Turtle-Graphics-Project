#!/usr/bin/env python3

import random

if __name__ == '__main__':

    NOUNS = ["aglet", "spile", "snood", "cacophony", "paradigm", "precipice", "reagent", "secateurs", "hackle", "directorate"]
    ADJECTIVES = ["peculiar", "garrulous", "ineluctable", "innocuous", "tractable", "vexatious", "ineffable", "intrinsic", "cogent", "contemporaneous"]
    ADVERBS = ["assiduously", "solicitously", "luxuriantly", "tremulously", "maniacally", "hydroponically", "precipitously", "sonorously", "industriously", "beseechingly"]

    print("Password Generator\n==================\n")

    while True:
        try:
            password_amount = int(input("How many passwords are needed? "))
            if 0 < password_amount <= 24:
                break
            else:
                print("Enter a value between 1 and 24")

        except ValueError:
            print("Please enter a numerical value")

    for i in range(password_amount):
        print(i + 1, "-->", random.choice(ADVERBS) + random.choice(ADJECTIVES) + random.choice(NOUNS))
