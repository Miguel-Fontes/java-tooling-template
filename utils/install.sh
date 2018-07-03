#!/bin/bash
# install.sh
#
# Scripted download and installation of Java Tooling Template Archetype!
# This script works at the current working directory. Context is cleaned the context up after installation.
#
# USAGE: ./install.sh [VERSION_TAG]
#        ./install.sh 1.4
#        ./install.sh
#
#     VERSION_TAG: The version to be installed. Must be a tag name, taken from Github Releases (https://github.com/Miguel-Fontes/java-tooling-template/releases)
#                  If no version is specified, the most recent one is fetched and installed

declare VERSION="$1"
declare -r RED='\033[0;31m'

setVersion() {
    if [ -z "$VERSION" ]; then
        # Kudos to Lukechilds and peschu123 for this nice line! (https://gist.github.com/lukechilds/a83e1d7127b78fef38c2914c4ececc3c)
        VERSION=$(curl --silent "https://api.github.com/repos/Miguel-Fontes/java-tooling-template/releases/latest" | grep -Po '"tag_name": "\K.*?(?=")')
    fi

    echo -e "Version $VERSION will be installed..."
}

execute() {

    # Downloads the selected version from github releases
    echo -e "Downloading selected version from github releases...\n"
    wget https://github.com/Miguel-Fontes/java-tooling-template/releases/download/$VERSION/java-tooling-template-archetype-$VERSION.tar.gz


    if [ ! -f "java-tooling-template-archetype-$VERSION.tar.gz" ]; then
        echo -e "${RED}An error ocurred downloading java-tooling-template-"$VERSION".tar.gz."
        echo -e "That version really exists? Check on https://github.com/Miguel-Fontes/java-tooling-template/releases!"
        exit 1
    fi

    # Uncompress the tar on current directory
    echo "Uncompressing tar.gz"
    tar -xvzf java-tooling-template-archetype-"$VERSION".tar.gz

    # Installs the jar on .m2
    echo -e "Intalling artifact to .m2\n"
    file=$(find . -name '*.jar' -printf "%f\n")
    mvn install:install-file                                  \
      -Dfile="$file"                                          \
      -DgroupId=br.com.miguelfontes                           \
      -DartifactId=java-tooling-template-archetype            \
      -Dpackaging=jar                                         \
      -Dversion=$VERSION

    # Cleanup
    echo -e "Cleaning up..."
    rm "$file"
    rm "java-tooling-template-archetype-$VERSION.tar.gz"

    echo -e "Done!"
}

# execute
setVersion
execute