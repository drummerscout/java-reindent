define 'java-reindent' do
  project.version = '0.1'
  package :jar
  manifest['Main-Class'] = 'reindent.Reindent'
  run.using :main => ['reindent.Reindent', 'input/PresenceServiceImpl.java', 'output/PresenceServiceImpl.java']
end

