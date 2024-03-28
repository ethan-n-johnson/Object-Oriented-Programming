CXXFLAGS += --std=c++17

all: hello_me hello_all

hello_me: hello_me.o
	$(CXX) $(CXXFLAGS) -o hello_me hello_me.o

hello_me.o: hello_me.cpp
	$(CXX) $(CXXFLAGS) -c hello_me.cpp

hello_all: hello_all.o
	$(CXX) $(CXXFLAGS) -o hello_all hello_all.o

hello_all.o: hello_all.cpp
	$(CXX) $(CXXFLAGS) -c hello_all hello_all.cpp

clean:
	-rm -f *.o *.gch *~ a.out hello_me hello_all
