#!/usr/bin/env python3

import random
import sys
from re import sub
import os

if __name__ == '__main__':

    if not os.path.exists("students.txt"):
        print("Error: file cannot be located")
        sys.exit(2)

    student_file = open("students.txt", 'r')
    email_file = open("emails.txt", 'w')

    students = student_file.readlines()

    for student in students:
        ucas_numbers = student[:8]
        full_name = student[9:]
        student_split = full_name.split(", ")
        first_name = student_split[1]
        second_name = sub(r"[^a-zA-Z]", "", student_split[0])
        random_num = str(random.randint(1000, 9999))
        initials = ".".join(char for char in first_name if char.isupper())

        emails = f"{initials}.{second_name}{random_num}@poppleton.ac.uk"

        email_file.write(ucas_numbers + " " + emails.lower() + "\n")

    student_file.close()
    email_file.close()

    sys.exit(1)
