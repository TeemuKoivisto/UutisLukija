git clone https://github.com/hy-ohtu/PaivanUutiset.git
git clone https://github.com/hy-ohtu/HackerNewsUutiset
cd PaivanUutiset && mvn install
cd ../HackerNewsUutiset && mvn install
cd ../
mvn install -DskipTests=true -Dmaven.javadoc.skip=true -B -V

