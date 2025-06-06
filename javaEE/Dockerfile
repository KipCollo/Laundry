# Use the official Tomcat 10.1 base image with JDK 21
FROM tomcat:10.1-jdk21

# Set environment variables (if needed)
ENV CATALINA_HOME /usr/local/tomcat

# Copy your WAR file or project files to the Tomcat webapps directory
COPY /path/to/your/app.war $CATALINA_HOME/webapps/

# Expose port 8080 (default port for Tomcat)
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
