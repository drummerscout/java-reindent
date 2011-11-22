repositories.remote << 'http://repo1.maven.org/maven2'

JCOMMANDER = 'com.beust:jcommander:jar:1.17'

define 'java-reindent' do
  project.version = '0.1'
  project.group = 'gvsu'
  
  compile.options.target = '1.6'
  compile.with JCOMMANDER
  
  package :jar
  
  manifest['Main-Class'] = 'reindent.Reindent'
  manifest['Copyright'] = 'Taylor Countryman (C) 2011'
  
  run.using :main => ['reindent.Reindent', 'input/PresenceServiceImpl.java', 'output/PresenceServiceImpl.java']
end

