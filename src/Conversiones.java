public class Conversiones {
        private double USD;
        private double EUR;
        private double CAD;
        private double BGN;
        private double AUD;

        // Constructor
        public Conversiones(double USD, double EUR, double CAD, double BGN, double AUD) {
            this.USD = USD;
            this.EUR = EUR;
            this.CAD = CAD;
            this.BGN = BGN;
            this.AUD = AUD;
        }

        // Getters y Setters
        public double getUSD() {
            return USD;
        }

        public void setUSD(double USD) {
            this.USD = USD;
        }

        public double getEUR() {
            return EUR;
        }

        public void setEUR(double EUR) {
            this.EUR = EUR;
        }

        public double getCAD() {
            return CAD;
        }

        public void setCAD(double CAD) {
            this.CAD = CAD;
        }

        public double getBGN() {
            return BGN;
        }

        public void setBGN(double BGN) {
            this.BGN = BGN;
        }

        public double getAUD() {
            return AUD;
        }

        public void setAUD(double AUD) {
            this.AUD = AUD;
        }
}

