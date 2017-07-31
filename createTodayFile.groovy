#!/usr/bin/env groovy
// def p = "/Users/yamap_55/github/yamap55/"
def s = this.class.protectionDomain.codeSource.location.path
def p = (s=~/^(.*)\//)[0][0]

def template = "template.md"

// get branch name
def dd = "git symbolic-ref --short HEAD".execute().text
def m = dd =~ /^(\d{4})(\d{2})(\d{2})$/
def year = m[0][1]
def month = m[0][2]
def day = m[0][3]

def dir = "${p}${year}/${year}${month}/"
if (!new File(dir).exists()) {
  new File(dir).mkdirs()
}

def newFilePath = "${dir}/${year}${month}${day}.md"

new File(newFilePath).write(new File("${p}${template}").getText("UTF-8"),"UTF-8")

println "create new file : ${newFilePath}"
