CXXFLAGS += --std=c++17

odds: odds.o
	$(CXX) $(CXXFLAGS) -o odds odds.o
odds.o: odds.cpp
	$(CXX) $(CXXFLAGS) -c odds.cpp
clean:
	rm -f *.o *.gch *~ a.out odds