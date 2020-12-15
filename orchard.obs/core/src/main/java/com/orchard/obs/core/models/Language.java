package com.orchard.obs.core.models;

public class Language 
{

	
        private String path;
        private String countrycode;
        private String languagecode;
        private String name;
        private boolean selected;

        public Language(String path, String countrycode, String languagecode, String name, boolean selected) {
            this.path = path;
            this.countrycode = countrycode.toUpperCase();
            this.languagecode = languagecode;
            this.name = name;
            this.selected = selected;
        }

        public String getPath() {
            return path;
        }

        public String getCountrycode() {
            return countrycode;
        }

        public String getLanguagecode() {
            return languagecode;
        }

        public String getName() {
            return name;
        }

        public boolean isSelected() {
            return selected;
        }
    }



