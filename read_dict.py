import json, pymysql
import os, sys


def database_write(k):
	conn = pymysql.connect(host='localhost', port=3306, user='root', passwd='1234', db='dito')

	cur = conn.cursor()

	print("writing to db")

	try:
		cur.execute("""INSERT INTO dict(dname) VALUES (%s)""", (k))
		print("wrote to db")
		conn.commit()
	except:
		print("deu rollback")
		conn.rollback()

	cur.close()
	conn.close()

def load_words():
    try:
        filename = os.path.dirname(os.path.abspath(__file__))+"\english_word_list.txt"
        with open(filename,"r") as english_dictionary:
            valid_words = json.load(english_dictionary)
            return valid_words
    except Exception as e:
        return str(e)

def load_from_text():
    try:
        filename = os.path.dirname(os.path.abspath(__file__))+"\english_word_list.txt"
        with open(filename,"r") as english_dictionary:
            valid_words = english_dictionary.readlines()
            return valid_words
    except Exception as e:
        return str(e)

if __name__ == '__main__':
    english_words = load_from_text()
    # demo print
for k in english_words:
	database_write(k)