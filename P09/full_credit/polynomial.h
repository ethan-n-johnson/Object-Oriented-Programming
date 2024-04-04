class Polynomial{
    public:
        Polynomial(std::vector<double> coefficients);
        virtual ~Polynomial();
        virtual std::vector<double> solve();
    private:
        std::vector<double> _coefficients;
};