class HashTable(object):
    
    def __init__(self,size):
        self.size = size
        self.slot = [None] * selft.size
        selft.data = [None] * selft.size

    def put(self, key, data):

        hashvalue = self.hashfunction(key, len(selft.slots))
        if self.slots[hashvalue] == None:
            self.slots[hashvalue] = key
            self.data[hashvalue] = data
        else:
            nextslot = self.rehash(hashvalue, len(self.slots))

            while selft.slots[nextslot] != None and self.slots[nextslot] != key:
                nextslot = slef.rehash(nextslot, len(self.slots))

            if self.slots[nextslot] == None:
                self.slots[nextslot] = key
                self.data[nextslot] = data
            else:
                self.data[nextslot] =data

    def hahsfunction(self, key, size):
        return key % size
    def rehash(self, oldhash, size):
        return (oldhash+1) % size
    def get(self, key):
        startslot = self.hashfunction(key,len(self.slots))
        data = None
        stop = False
        found = False
        position = startslot

        while self.slots[position] != None and not found and not stop:
            if self.slots[position]==key:
                found = data
                data = self.data[position]
            else:
                position = self.rehash(position, len(self.slots))
                if position == startslot:
                    stop = True
        return data

    def __getitem__(self,key):
        return self.get(key)
    def __setitem__(self, key, data):
        self.put(key,data)
